// Place your Spring DSL code here
beans = {
    hibernateStringEncryptor(org.jasypt.hibernate.encryptor.HibernatePBEStringEncryptor) {
        registeredName = "gormEncryptor"
        providerName = "BC"
        algorithm = "PBEWITHSHA256AND128BITAES-CBC-BC"
        keyObtentionIterations = 1000
//        password = "s3kr1t"
        config = { org.jasypt.encryption.pbe.config.WebStringPBEConfig c ->
            name = 'webConfig'
            validationWord = 'valid'
        }
    }
}