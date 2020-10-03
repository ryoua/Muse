package model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import status.TemplateStatus;

import javax.persistence.*;


/**
 * * @Author: RyouA
 * * @Date: 2020/9/29
 **/
@Data
@Entity(name = "c_template")
@EntityListeners({AuditingEntityListener.class})
public class Template extends Base {
    /**
     * 模板ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long templateId;

    /**
     * 模板状态
     */
    @Column(nullable = false, columnDefinition = "int default 0")
    private TemplateStatus templateStatus;

    /**
     * 消息名称
     */
    @Column(nullable = false, length = 128)
    private String messageName;
    /**
     * 发送周期类型, 1:立即发送, 2:定时发送, 3:周期发送
     */
    @Column(nullable = false)
    private int sendCycleType;
    /**
     * 接受者Id的类型, 1: userid, 2.did ,3: phone
     */
    @Column(nullable = false)
    private int receiverIdType;
    /**
     * 创建者信息
     */
    @Column(length = 64)
    private String creatorName;
    /**
     * 创建者电话
     */
    @Column(length = 32)
    private String creatorPhone;

    /**
     * 消息体, 直接使用一整个JSON保存
     */
    private String messageBody;


}
