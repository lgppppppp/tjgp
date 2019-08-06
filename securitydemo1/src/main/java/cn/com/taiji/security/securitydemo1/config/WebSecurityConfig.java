package cn.com.taiji.security.securitydemo1.config;

import cn.com.taiji.security.securitydemo1.extend.CustomUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;


/**
 * @program: securitydemo1
 * @description:
 * @author: lgppppppp
 * @create: 2019-08-01 11:12
 **/
@EnableWebSecurity(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Override
    //设置用户名和密码
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customUserDetailService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/css/**", "/images/**", "/js/**", "/webjars/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        logger.info("security demo");

        http
                .authorizeRequests()//对请求授权
                .antMatchers("/error").permitAll()
//                .antMatchers("/user").hasAnyRole("user","admin")//对user授权，user可以访问user页面
//                .antMatchers("/admin").hasRole("admin")//admin授权 ，admin可以访问admin页面
                .anyRequest().access("@customerAuthService.canAccess(request,authentication)")
//                .anyRequest().authenticated()//所有请求都需要认证
                .and()
                .formLogin()//定义登陆方式为form表单登陆
                .loginPage("/myLogin")//定义登陆页面
//                .loginProcessingUrl("/myLogin")//登录请求拦截的url,也就是form表单提交时指定的action(自定义登陆路径)
                .defaultSuccessUrl("/index")
                //定义默认登陆成功跳转页面的URL;
                // 默认情况下，用户登录成功后由于RequestCache中保存着登录之前的url，将自动跳转到该页面
//                .successHandler(new SavedRequestAwareAuthenticationSuccessHandler() {
//                    @Override
//                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//
////                        httpServletResponse.setContentType("application/json;charset=UTF-8");
////                        httpServletResponse.getWriter().write("error_code=0,message:欢迎登陆");
//                    }
//                })
                .permitAll()
                .and().csrf().disable();//关闭csrf防护
        ;
    }

    //新建一个用户在内存中
//    @Bean
//    public UserDetailsService userDetailsService() {
//        String passsword=passwordEncoder().encode("1");
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("a")
//                .password(passsword)
//                .roles("user").build());
//        manager.createUser(User.withUsername("b")
//                .password(passsword)
//                .roles("admin").build());
//        return manager;
//    }

    //设置一个passwordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
