package com.example.demo.config;

/**
 * @author hongjin.zhu
 * @description
 * @date 2018年10月29日 09:34
 * @modified By
 */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig /*extends WebSecurityConfigurerAdapter*/ {

//    @Autowired
//    UserDao userDao;

//    @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("test").password("123").roles("USER");

//        super.configure(auth);
//        auth.userDetailsService(new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//                //查询数据库 可以使用spring-jpa-data 的 findOne()
//                return userDao.loadUserByUsername(s);
//            }
//        });
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .formLogin()
//                .failureUrl("/login?error")
//                .defaultSuccessUrl("/home")
//                .permitAll();
//        super.configure(http);
//    }

    /**
     * 这个密码编码bean的作用参见官方文档：
     * <link> https://docs.spring.io/spring-security/site/docs/5.0.2.RELEASE/reference/htmlsingle/#troubleshooting <link/>
     *
     * @return
     */
//    @Bean
//    public static NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }

}
