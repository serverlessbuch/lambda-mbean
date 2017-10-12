# Lambda MBean Info

Ever wanna know, how the Java environment for your Lambda function is configured?
Just use `MXBeans` and you get know many interesting information.

This AWS Lambda function runs every 5 minutes and reads information from these MXBeans

    RuntimeMXBean
    MemoryMXBean
    OperatingSystemMXBean
    
and writes them to the log (AWS CloudWatch).
