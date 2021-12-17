function openModal(modal) {
    const myModal = new bootstrap.Modal(document.getElementById(modal));
    myModal.show();
}
/*
 * user
 */
function confirmDeleteUser(e) {
    const userId = e.target.firstElementChild.innerHTML;
    const status = e.target.lastElementChild.innerHTML;
    document.getElementById("btn-delete-user").href = "/user/all/delete?userId=" + userId + "&status=" + status;
    openModal("confirmDeleteUserModal");
}

function confirmLockUser(e) {
    const userId = e.target.firstElementChild.innerHTML;
    const status = e.target.lastElementChild.innerHTML;
    document.getElementById("btn-lock-user").href = "/user/all/lock?userId=" + userId + "&status=" + status;
    openModal("confirmLockUserModal");
}

function confirmUnlockUser(e) {
    const userId = e.target.firstElementChild.innerHTML;
    const status = e.target.lastElementChild.innerHTML;
    document.getElementById("btn-unlock-user").href = "/user/all/unlock?userId=" + userId + "&status=" + status;
    openModal("confirmUnlockUserModal");
}

/*
 * online store
 */
function confirmLockOnlineStore(e) {
    const onlineStoreId = e.target.firstElementChild.innerHTML;
    document.getElementById("btn-lock-online-store").href = "online-store/lock?onlineStoreId=" + onlineStoreId;
    openModal("confirmLockOnlineStoreModal");
}

function confirmUnlockOnlineStore(e) {
    const onlineStoreId = e.target.firstElementChild.innerHTML;
    document.getElementById("btn-unlock-online-store").href = "online-store/unlock?onlineStoreId=" + onlineStoreId;
    openModal("confirmUnlockOnlineStoreModal");
}