/**
 * FileName      : $Id: WebAppSecurityInitializer.java $
 *
 * Copyright Notice: ©2004 -- Confidential and Proprietary
 *
 * All rights reserved.
 * This software is the confidential and proprietary information of Ltd
 * ("Confidential Information"). You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the license agreement you
 * entered into with POS.
 */
package com.pos.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @author pos
 *
 */
@Order(1)
public class WebAppSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    //WebAppSecurityInitializer
}
