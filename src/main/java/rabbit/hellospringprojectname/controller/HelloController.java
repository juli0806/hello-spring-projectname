package rabbit.hellospringprojectname.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;//자동으로 안 뜸
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")//웹어플리케이션에서 /hello라고 들어오면 이 메소드를 실행시켜준다.
    public String hello(Model model){
        model.addAttribute("data","hello!");//hello! 라고 넘길거임
        return "hello";//resources/templat에 있는 hello.html
        //그럼 얘는 view 네임인가
    }


        @GetMapping("hello-mvc")
        public String helloMvc(@RequestParam("name") String name, Model model) {
            model.addAttribute("name", name);
            return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http body부에 이 데이터를 직접 넣어주겠다
    public String helloString(@RequestParam(name="name") String name){
        return "hello"+name;
    }

    @GetMapping("hello-api")
    @ResponseBody //데이터를 넣어줌
    public Hello helloApi (@RequestParam("name") String name){//객체
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //json type으로 return


    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
