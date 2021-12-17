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

/*
 * Work
 */

function confirmDeleteRecruitment(e) {
    const recruitmentId = e.target.firstElementChild.innerHTML;
    document.getElementById("btn-delete").href = "/work/recruitment/delete?recruitmentId="+recruitmentId;
    openModal("confirmDeleteModal");
}

function confirmDeleteFindJob(e) {
    const findJobId = e.target.firstElementChild.innerHTML;
    document.getElementById("btn-delete").href = "/work/find-job/delete?findJobId="+findJobId;
    openModal("confirmDeleteModal");
}

function confirmApproveRecruitment(e) {
    const recruitmentId = e.target.firstElementChild.innerHTML;
    document.getElementById("btn-approve").href = "/work/recruitment/approve?recruitmentId="+recruitmentId;
    openModal("confirmApproveModal");
}

function confirmApproveFindJob(e) {
    const findJobId = e.target.firstElementChild.innerHTML;
    document.getElementById("btn-approve").href = "/work/find-job/approve?findJobId="+findJobId;
    openModal("confirmApproveModal");
}

/*
 * Traffic
 */

function confirmDeleteBus(e) {
    const busId = e.target.firstElementChild.innerHTML;
    document.getElementById("btn-delete").href = "/bus/delete?busId="+busId;
    openModal("confirmDeleteModal");
}

function confirmDeleteMotorbikeTaxi(e) {
    const motorbikeId = e.target.firstElementChild.innerHTML;
    document.getElementById("btn-delete").href = "/motorbike-taxi-drivers/delete?motorbikeId="+motorbikeId;
    openModal("confirmDeleteModal");
}