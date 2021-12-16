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
/*
 * online store
 */
function confirmDeleteOnlineStore(e) {
    const onlineStoreId = e.target.firstElementChild.innerHTML;
    document.getElementById("btn-delete-online-store").href = "online-store/delete?onlineStoreId=" + onlineStoreId;
    openModal("confirmDeleteOnlineStoreModal");
}