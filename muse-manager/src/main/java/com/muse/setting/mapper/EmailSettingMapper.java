package com.muse.setting.mapper;

import com.muse.setting.model.EmailSetting;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * * @Author: RyouA
 * * @Date: 2020/10/10
 **/
@Mapper
public interface EmailSettingMapper {

    /**
     * 新增邮件设置
     * @param emailSetting
     */
    @Insert(value = "insert into m_email_setting (uid, name, address, port, account, username, password, isSSL, isTLS, remark) values " +
            "(#{uid} , " +
            "#{name} , " +
            "#{address} , " +
            "#{port} , " +
            "#{account} ," +
            "#{username} ," +
            "#{password} ," +
            "#{isSSL} ," +
            "#{isTLS} ," +
            "#{remark} )")
    int addEmailSetting(EmailSetting emailSetting);

    /**
     * 根据id获取邮件设置
     * @param id
     * @return
     */
    @Select(value = "select id, name, address, port, account, username, password, isSSL, isTLS, createTime, updateTime, remark from m_email_setting where id = #{id} and uid = #{uid} and valid = 1")
    EmailSetting getEmailSettingById(@Param("uid") long uid, @Param("id") long id);

    /**
     * 获取全部邮件设置
     * @param uid
     * @return
     */
    @Select(value = "select id, name, address, port, account, username, password, isSSL, isTLS, createTime, updateTime, remark from m_email_setting where valid = 1 and uid = #{uid}")
    List<EmailSetting> getAllEmailSetting(long uid);

    /**
     * 根据id删除邮件设置
     * @param id
     */
    @Update(value = "update m_email_setting set valid = 0 , updateTime = current_timestamp where id = #{id}")
    int deleteEmailSettingById(long id);

    /**
     * 根据邮件设置
     * @param emailSetting
     */
    @Update(value = "update m_email_setting set " +
            "name = #{name} , " +
            "address = #{address} , " +
            "port = #{port} , " +
            "account = #{account} , " +
            "username = #{username} , " +
            "password = #{password} , " +
            "isTLS = #{isTLS} , " +
            "isSSL = #{isSSL} , " +
            "updateTime = current_timestamp , " +
            "remark = #{remark} " +
            "where id = #{id} ")
    int updateEmailSetting(EmailSetting emailSetting);
}
