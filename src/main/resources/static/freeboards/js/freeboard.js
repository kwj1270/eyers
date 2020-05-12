var freeboard = {
    init : function(){
        var _this = this;
        $('#btn-freeboard-write').on('click', function(){
            _this.go_write();
        })
    },
    go_write : function(){
        window.location.href = 'http://localhost:8080/freeboard/write'
    }
}
freeboard.init();