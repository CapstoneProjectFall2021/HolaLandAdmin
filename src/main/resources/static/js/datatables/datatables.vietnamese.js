var vietnamese = {
  "sProcessing": "Đang xử lý...",
  "sLengthMenu": "Xem _MENU_ mục",
  "sZeroRecords": "Không tìm thấy dòng nào phù hợp",
  "sInfo": "Đang xem _START_ đến _END_ trong tổng số _TOTAL_ mục",
  "sInfoEmpty": "Đang xem 0 đến 0 trong tổng số 0 mục",
  "sInfoFiltered": "(được lọc từ _MAX_ mục)",
  "sInfoPostFix": "",
  "sSearch": "Tìm kiếm:",
  "sUrl": "",
  "oPaginate": {
    "sFirst": "Đầu",
    "sPrevious": "Trước",
    "sNext": "Tiếp",
    "sLast": "Cuối"
  }
};

$(document).ready(function() {

  var dtable = $('#user-table, #food-table, #club-table, #recruitment-table, #find-job-table, #bus-table, #motorbike-table, #online-store-table' ).dataTable({
    "oLanguage": vietnamese
  });
});

$(document).ready(function() {
  $('#user-table, #club-table, #recruitment-table, #find-job-table, #bus-table, #motorbike-table, #online-store-table').DataTable();
});