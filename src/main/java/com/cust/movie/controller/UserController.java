package com.cust.movie.controller;

import com.cust.movie.controller.ex.*;
import com.cust.movie.entity.User;
import com.cust.movie.service.IUserService;
import com.cust.movie.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

//@Controller //此注解表示此类交由Spring框架来管理
@RestController  //等效于 @Controller+@ResponseBody
@RequestMapping("/user")
public class UserController extends BaseController {//注册模块的控制层
    @Autowired
    private IUserService userService;

    @RequestMapping("/reg")
    // @ResponseBody //  表示此方法的响应结果将以json格式进行数据的响应给到前端
    public JsonResult<Void> reg(User user){
        userService.reg(user);
        return new JsonResult<>(OK);
    }

    @RequestMapping("/login")
    public JsonResult<User> login(String username, String password, HttpSession session){
        // 调用业务对象的方法执行登录，并获取返回值
        User data = userService.login(username, password);

        // 向session域对象中完成数据的绑定（session是全局的）参数共享
        session.setAttribute("uid",data.getUid());
        session.setAttribute("username",data.getUsername());

        // 将以上返回值和状态码OK封装到响应结果中并返回
        return new JsonResult<User>(OK,data);
    }

    @RequestMapping("/change_password")
    public JsonResult<Void> changPassword(String oldPassword,String newPassword,HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changPassword(uid,username,oldPassword,newPassword);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("/get_by_uid")
    public JsonResult<User> getByUid(HttpSession session){
        // 从HttpSession对象中获取uid
        Integer uid = getUidFromSession(session);
        // 调用业务对象执行获取数据
        User data = userService.getByUid(uid);
        // 响应成功和数据
        return new JsonResult<User>(OK, data);
    }

    @RequestMapping("/change_info")
    public JsonResult<Void> changeInfo(User user,HttpSession session){
        // 从HttpSession对象中获取uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行修改用户资料
        userService.changeInfo(uid,username,user);
        // 响应成功
        return new JsonResult<Void>(OK);
    }

    // 设置上传文件的最大值
    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;

    // 限制上传文件的类型
    public static final List<String> AVATAR_TYPE = new ArrayList<>();
    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }
    /**
     * MultipartFile接口是SpringMVC提供一个接口，这个接口为我们包装了获取文件类型的数据（任何
     * 类型的file都可以接收），Spring Boot 整合了SpringMVC，只需要再处理请求的方法参数列表上声明
     * 一个参数类型为MultipartFile的参数，然后Spring Boot会自动将文件中的数据赋值给这个参数
     * @param session session域对象
     * @param avatar 用户上传的头像文件
     * @return
     */
    @PostMapping("/change_avatar")
    public JsonResult<String> changeAvatar (HttpSession session,
                                            @RequestParam("file") MultipartFile avatar) {
        // 判断文件是否为空
        if (avatar == null) {
            throw new FileEmptyException("文件为空");
        }
        // 判断文件大小是否超过最大限制
        if (avatar.getSize() > AVATAR_MAX_SIZE) {
            throw new FileSizeException("文件超出限制");
        }
        // 判断文件类型是否为指定的类型
        String contentType = avatar.getContentType();
        // contains方法:若集合中包含某个元素则返回true
        if (!AVATAR_TYPE.contains(contentType)) {
            throw new FileTypeException("文件类型不支持");
        }
        // 上传的文件的路径../upload/xxx.png
        String realPath = session.getServletContext().getRealPath("upload");
        // 创建一个File对象指向这个路径
        File dir = new File(realPath);
        // 判断当前目录是否存在,若不存在则进行创建
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // 获取到当前的文件名，使用UUID工具生成一个新的字符串作为新的文件名
        // 返回的文件名为:例."avatar01.png",不包含路径
        String originalFilename = avatar.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        // 获取到文件的后缀名
        String suffix = originalFilename.substring(index);
        // 将前缀名和后缀名拼接成新的文件名
        String newFilename = UUID.randomUUID().toString().toUpperCase() + suffix;
        // 再指定的路径下创建一个文件名为newFilename的空文件
        File dest = new File(dir,newFilename);
        // 将参数avatar中的数据写入到这个空文件中
        try {
            // 将avatar文件中的数据写入到dest文件中
            avatar.transferTo(dest);
        } catch (IOException e) {
            throw new FileUploadIOException("文件读写异常");
        } catch (FileStateException e) {
            throw new FileStateException("文件状态异常");
        }

        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 返回头像的路径/upload/test.png
        String avatarName = "/upload/" + newFilename;
        userService.changeAvatar(uid,username,avatarName);
        // 返回用户头像的路径给前端页面，将来用于头像的展示使用
        return new JsonResult<>(OK,avatarName);
    }
}
