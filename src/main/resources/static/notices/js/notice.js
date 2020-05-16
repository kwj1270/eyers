var notice = {
    init : function(){
        var _this = this;
        $('#btn-notice-write').on('click', function(){
            _this.go_write();
        })
    },
    go_write : function(){
        window.location.href = 'http://localhost:8080/notice/write'
    }
}
notice.init();