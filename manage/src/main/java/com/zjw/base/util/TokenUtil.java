package com.zjw.base.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;

public class TokenUtil {

    private static final long EXPIRE_TIME= 15*60*100;
    private static final String TOKEN_SECRET="zhaojiawei666";

    /**
     * 生成签名，十五分钟过期
     * @param userId
     * @param role
     * @return
     */
    public static String sign(String userId,String role){
        //过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        //私钥进行HS256加密
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        //设置头部信息
        HashMap<String, Object> map = new HashMap<>();
        map.put("typ","JWT");
        map.put("alg","HS256");
        //附带userId,role信息，生成签名
        return JWT.create().withHeader(map)
                .withClaim("userId",userId)
                .withClaim("role",role)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    public static String verify(String token){
        try{
            //使用HS256解密
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier build = JWT.require(algorithm).build();
            DecodedJWT verify = build.verify(token);
            Claim userId = verify.getClaim("userId");
            Claim role = verify.getClaim("role");
            String s = userId.asString();
            return  "userId:"+s;
        }catch (Exception e){
            return  "签名被篡改";
        }

    }


    public static void main(String[] args) {
        String sign = TokenUtil.sign("z", "Z");
        System.out.println(sign);
        String verify = TokenUtil.verify(sign);
        System.out.println(verify);
    }
}
