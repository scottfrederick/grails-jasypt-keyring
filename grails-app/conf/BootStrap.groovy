import grails.keyring.OnlineAccount

class BootStrap {

    def init = { servletContext ->
        if (OnlineAccount.count() == 0) {
            createTestData()
        }
    }

    def destroy = {
    }

    def createTestData() {
/*
        new OnlineAccount(name: 'Amazon', url: 'www.amazon.com', userName: 'myname', password: 'amazon').save()
        new OnlineAccount(name: 'eBay', url: 'www.ebay.com', userName: 'myname', password: 'ebay').save()
        new OnlineAccount(name: 'Google', url: 'www.google.com', userName: 'myname', password: 'goog').save()
*/
    }
}
