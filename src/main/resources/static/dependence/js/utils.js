/*
 * @Author ThorLau
 * @CreateTime 2021/8/31 16:09
 * @Desc HTML工具类
 */
var utils = {
    alert: function (msg) {
        swal({
            title: '',
            text: msg,
            confirmButtonText: '确认'
        });
    },
    alertSuccess: function (msg) {
        swal({
            title: '',
            text: msg,
            type: 'success',
            confirmButtonText: '确认'

        });
    },
    alertConfirm: function (msg, callback) {
        swal({
            title: '',
            text: msg,
            type: 'warning',
            showCancelButton: true,
            closeOnConfirm: false,
            showLoaderOnConfirm: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: '确认',
            cancelButtonText: '取消',
            allowOutsideClick: true
        }, callback);
    },
    alertFail: function (msg) {
        swal({
            title: '',
            text: msg,
            type: 'error',
            confirmButtonText: '确认'

        });
    },
    alertClose: function () {
        swal.close();
    },
}