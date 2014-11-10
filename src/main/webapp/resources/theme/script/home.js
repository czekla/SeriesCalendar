function handleLoginRequest(xhr, status, args) {
    if (args.validationFailed || !args.loggedIn) {
        //PF('loginDlg').jq.effect("shake", {times: 5}, 100);
    }
    else {
        PF('loginDlg').hide();
    }
}

function handleRegisterRequest(xhr, status, args) {
    if (args.validationFailed) {
        //PF('loginDlg').jq.effect("shake", {times: 5}, 100);
    }
    else {
        PF('registerDlg').hide();
    }
}

function start() {
    PF('statusDialog').show();
}

function stop() {
    PF('statusDialog').hide();
}