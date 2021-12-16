/*
 *
 */
function openModal(modal) {
    const myModal = new bootstrap.Modal(document.getElementById(modal));
    myModal.show();
}

function showToast(id) {
    const toast = new bootstrap.Toast(document.getElementById(id));
    toast.show();
}

function showContent(e) {
    const content = e.target.firstElementChild.innerHTML;
    document.getElementById("content").innerHTML = content;
    openModal("showContentModal");
}

/*
 * Club
 */

function confirmDeleteClub(e) {
    const clubId = e.target.firstElementChild.innerHTML;
    document.getElementById("btn-delete").href = "/club/delete?clubId="+clubId;
    openModal("confirmDeleteModal");
}