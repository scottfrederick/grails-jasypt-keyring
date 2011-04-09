package grails.keyring

import com.bloomhealthco.jasypt.GormEncryptedStringType

class OnlineAccount {
    String name
    String url
    String userName
    String password

    static constraints = {
        name(blank: false, unique: true)
        url(blank: false)
        userName(blank: false)
        password(blank: false)
    }

    static mapping = {
        userName type: GormEncryptedStringType
        password type: GormEncryptedStringType
    }
}
