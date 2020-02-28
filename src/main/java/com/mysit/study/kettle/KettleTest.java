package com.mysit.study.kettle;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

public class KettleTest {


    public static void main(String[] args) throws KettleException {
        KettleEnvironment.init();
        TransMeta transMeta = new TransMeta("C:\\Users\\yss\\Desktop\\localTest.ktr");
        Trans trans = new Trans(transMeta);
        trans.execute(null);
        trans.waitUntilFinished();
    }


}
