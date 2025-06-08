package org.example.creek.model;

import java.io.Serial;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SyncIpRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 3776332225767466135L;

    /**
     * ip
     */
    private String ip;

    /**
     * 网络名称
     */
    private String name;

    /**
     * 时间戳
     */
    private Long timestamp;

}
