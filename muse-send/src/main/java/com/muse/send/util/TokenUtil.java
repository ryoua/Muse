package com.muse.send.util;

import com.muse.config.JwtConfig;
import com.muse.exception.MuseException;
import com.muse.model.ResultCode;
import com.muse.util.Base64Util;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;

/**
 * Token工具类
 * * @Author: RyouA
 * * @Date: 2020/10/16
 **/
@Configuration
@EnableConfigurationProperties(JwtConfig.class)
public class TokenUtil {

    private static Logger log = LoggerFactory.getLogger(TokenUtil.class);

    public static final String AUTH_HEADER_KEY = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 解析jwt
     *
     * @param jsonWebToken
     * @param base64Security
     * @return
     */
    public static Claims parseJWT(String jsonWebToken, String base64Security) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (ExpiredJwtException eje) {
            log.error("===== Token过期 =====", eje);
            throw new MuseException(ResultCode.PERMISSION_TOKEN_EXPIRED);
        } catch (Exception e) {
            log.error("===== Token解析异常 =====", e);
            throw new MuseException(ResultCode.PERMISSION_TOKEN_INVALID);
        }
    }

    /**
     * 从token中获取用户名
     *
     * @param token
     * @param base64Security
     * @return
     */
    public static String getUsername(String token, String base64Security) {
        return parseJWT(token, base64Security).getSubject();
    }

    /**
     * 从token中获取用户ID
     *
     * @param token
     * @param base64Security
     * @return
     */
    public static String getUserId(String token, String base64Security) {
        String userId = parseJWT(token, base64Security).get("userId", String.class);
        return Base64Util.decode(userId);
    }

    /**
     * 是否已过期
     *
     * @param token
     * @param base64Security
     * @return
     */
    public static boolean isExpiration(String token, String base64Security) {
        return parseJWT(token, base64Security).getExpiration().before(new Date());
    }
}
