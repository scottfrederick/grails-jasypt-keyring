package grails.keyring

class OnlineAccountController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [onlineAccountInstanceList: OnlineAccount.list(params), onlineAccountInstanceTotal: OnlineAccount.count()]
    }

    def create = {
        def onlineAccountInstance = new OnlineAccount()
        onlineAccountInstance.properties = params
        return [onlineAccountInstance: onlineAccountInstance]
    }

    def save = {
        def onlineAccountInstance = new OnlineAccount(params)
        if (onlineAccountInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'onlineAccount.label', default: 'OnlineAccount'), onlineAccountInstance.id])}"
            redirect(action: "show", id: onlineAccountInstance.id)
        }
        else {
            render(view: "create", model: [onlineAccountInstance: onlineAccountInstance])
        }
    }

    def show = {
        def onlineAccountInstance = OnlineAccount.get(params.id)
        if (!onlineAccountInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'onlineAccount.label', default: 'OnlineAccount'), params.id])}"
            redirect(action: "list")
        }
        else {
            [onlineAccountInstance: onlineAccountInstance]
        }
    }

    def edit = {
        def onlineAccountInstance = OnlineAccount.get(params.id)
        if (!onlineAccountInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'onlineAccount.label', default: 'OnlineAccount'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [onlineAccountInstance: onlineAccountInstance]
        }
    }

    def update = {
        def onlineAccountInstance = OnlineAccount.get(params.id)
        if (onlineAccountInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (onlineAccountInstance.version > version) {
                    
                    onlineAccountInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'onlineAccount.label', default: 'OnlineAccount')] as Object[], "Another user has updated this OnlineAccount while you were editing")
                    render(view: "edit", model: [onlineAccountInstance: onlineAccountInstance])
                    return
                }
            }
            onlineAccountInstance.properties = params
            if (!onlineAccountInstance.hasErrors() && onlineAccountInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'onlineAccount.label', default: 'OnlineAccount'), onlineAccountInstance.id])}"
                redirect(action: "show", id: onlineAccountInstance.id)
            }
            else {
                render(view: "edit", model: [onlineAccountInstance: onlineAccountInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'onlineAccount.label', default: 'OnlineAccount'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def onlineAccountInstance = OnlineAccount.get(params.id)
        if (onlineAccountInstance) {
            try {
                onlineAccountInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'onlineAccount.label', default: 'OnlineAccount'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'onlineAccount.label', default: 'OnlineAccount'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'onlineAccount.label', default: 'OnlineAccount'), params.id])}"
            redirect(action: "list")
        }
    }
}
