package com.huangzb.test.jpa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("email")
public class Email extends Contact{

}
