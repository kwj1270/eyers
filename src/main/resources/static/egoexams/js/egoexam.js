var egoexam = {
    init : function(){
        var _this = this;
        $('#btn-egoexam-write').on('click', function(){
            _this.go_write();
        })
    },
    go_write : function(){
        window.location.href = 'http://localhost:8080/egoexam/write'
    }
}
egoexam.init();