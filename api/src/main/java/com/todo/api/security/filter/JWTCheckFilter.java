//package com.todo.api.security.filter;
//
//import com.google.gson.Gson;
//import com.todo.api.dto.member.MemberDTO;
//import com.todo.api.util.JWTUtil;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//import java.util.Map;
//
//// 모든 경우 채크 하는것 상속 받음
//public class JWTCheckFilter extends OncePerRequestFilter {
//
//    // 제외 경로 설정
//    @Override
//    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
//
//        String path = request.getRequestURI();
//
//        if(path.startsWith("/api/member/register")){
//            return true;
//        }
//
//
//        // check 함
//        return false;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//
//
//        String authHeaderStr = request.getHeader("Authorization");
//
//        //Bearer //7 JWT문자열
//
//        try {
//            String accessToken = authHeaderStr.substring(7);
//            Map<String, Object> claims = JWTUtil.validateToken(accessToken);
//
//
//
//            //filterChain.doFilter(request, response);
//
//            String email = (String) claims.get("email");
//            String pw = (String) claims.get("pw");
//            String nickname = (String) claims.get("nickname");
//            Boolean social = (Boolean) claims.get("social");
//            List<String> roleNames = (List<String>) claims.get("roleNames");
//
//            MemberDTO memberDTO = new MemberDTO(email, pw, nickname, social.booleanValue(), roleNames);
//
//
//
//            UsernamePasswordAuthenticationToken authenticationToken
//                    = new UsernamePasswordAuthenticationToken(memberDTO, pw, memberDTO.getAuthorities());
//            //
//            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            filterChain.doFilter(request, response);
//
//        }catch (Exception e){
//
//
//
//            Gson gson =new Gson();
//            String msg = gson.toJson(Map.of("error","ERROR_ACCESS_TOKEN"));
//
//            response.setContentType("application/json");
//            PrintWriter printWriter = response.getWriter();
//            printWriter.println(msg);
//            printWriter.close();
//
//        }
//
//    }
//}
