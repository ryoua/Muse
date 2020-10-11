package com.muse.manager.setting.mapper;

import com.muse.manager.setting.model.EmailSetting;
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
    void addEmailSetting(EmailSetting emailSetting);

    /**
     * 根据id获取邮件设置
     * @param id
     * @return
     */
    @Select(value = "select (id, name, address, port, account, username, password, isSSL, isTLS, createTime, updateTime, remark) from m_email_setting where id = #{id} and value = 1")
    EmailSetting getEmailSettingById(long id);

    /**
     * 获取全部邮件设置
     * @param uid
     * @return
     */
    @Select(value = "select (id, name, address, port, account, username, password, isSSL, isTLS, createTime, updateTime, remark) from m_email_setting where valid = 1 and uid = #{uid}")
    List<EmailSetting> getAllEmailSetting(long uid);

    /**
     * 根据id删除邮件设置
     * @param id
     */
    @Update(value = "update m_email_setting set valid = 0 and updateTime = current_timestamp where id = #{id}")
    void deleteEmailSettingById(long id);

    /**
     * 根据邮件设置
     * @param emailSetting
     */
    @Update(value = "update m_email_setting set " +
            "name = #{name} and " +
            "address = #{address} and " +
            "port = #{port} and " +
            "account = #{account} and " +
            "username = #{username} and " +
            "password = #{password} and " +
            "isTLS = #{isTLS} and " +
            "isSSL = #{isSSL} and " +
            "updateTime = current_timestamp and " +
            "remark = #{remark} ")
    void updateEmailSetting(EmailSetting emailSetting);
}
