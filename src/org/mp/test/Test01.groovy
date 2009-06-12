package org.mp.test


import weka.core.converters.ConverterUtils.DataSource
import weka.core.Instances
import weka.core.Attribute;

/**
 * 
 * User: Marcus FREX
 * Date: 11-Jun-2009
 * Time: 14:53:00
 * 
 */




def DATA_PATH = "C:\\Documents and Settings\\Administrator\\Desktop\\ds_data\\arff\\weather.arff"


DataSource source = new DataSource(DATA_PATH);
Instances data = source.getDataSet();
 // setting class attribute if the data format does not provide this information
 // E.g., the XRFF format saves the class attribute information as well
if (data.classIndex() == -1)
   data.setClassIndex(data.numAttributes() - 1);

//println data.toSummaryString();
data.enumerateAttributes().each { attribute ->
    println attribute != null ? attribute.name() : attribute.toString()
    if (attribute != null) {
      attribute.enumerateValues().each { value ->
        println "\t" +value
      }
      if (attribute.isNumeric()) {
        println "\t[Numeric]"
      }
    }
}