/*
 * The MIT License (MIT)
 * ------------------------------------------------------------------
 * Copyright © 2019 Ramostear.All Rights Reserved.
 *
 * ProjectName: Java-group
 * @Author : <a href="https://github.com/lcy2013">MagicLuo</a>
 * @date : 2020-06-28
 * @version : 2.0.0-RELEASE
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package com.fufeng.dream.saas.master.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @program: Java-group
 * @description:
 * @author: <a href="https://github.com/lcy2013">MagicLuo</a>
 * @create: 2020-06-28 14:45
 */
@Data
@Entity
@Table(name = "MASTER_TENANT")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MasterTenant implements Serializable {

    @Id
    @Column(name="ID")
    private String id;

    @Column(name = "TENANT")
    @NotEmpty(message = "Tenant identifier must be provided")
    private String tenant;

    @Column(name = "URL")
    @Size(max = 256)
    @NotEmpty(message = "Tenant jdbc url must be provided")
    private String url;

    @Column(name = "USERNAME")
    @Size(min = 4,max = 30,message = "db username length must between 4 and 30")
    @NotEmpty(message = "Tenant db username must be provided")
    private String username;

    @Column(name = "PASSWORD")
    @Size(min = 4,max = 30)
    @NotEmpty(message = "Tenant db password must be provided")
    private String password;

    @Version
    private int version = 0;

}
