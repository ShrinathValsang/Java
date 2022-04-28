package com.futurex.services.FuturexUserApp;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;

public class UserId implements Serializable {

    private static final long serialVersionUID = 9085306695280999722L;

    public BigInteger userid;

    public BigInteger courseid;
}
