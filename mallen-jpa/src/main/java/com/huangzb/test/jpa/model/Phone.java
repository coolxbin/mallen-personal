package com.huangzb.test.jpa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("phone")
public class Phone extends Contact {

}
