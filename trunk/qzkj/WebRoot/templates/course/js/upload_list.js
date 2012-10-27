var params;
$(function() {
	$("[name='file_upload']").each(function(i,el) {
		makeupupload(i+1,$(el));
	});
    
});
function makeupupload(index,el) {
	el.uploadify({
        height        	: 16,
        width         	: 80,
        swf           	: 'templates/uploadify-v3.1/uploadify.swf',
        uploader      	: 'uploadfile.action',
        auto			: true,
        multi			: false,
        fileObjName		: 'file',
        debug			: false,
        method			: 'post',
        formData		: {},
        buttonText    	: '�ϴ���Ƶ',
        removeCompleted : false,
        overrideEvents : ['onUploadProgress'],
        onUploadStart: function(file) {//�ϴ���ʼʱ������ÿ���ļ�����һ�Σ�
			params = {"fname" : encodeURIComponent(encodeURIComponent(file.name)), "fsize" : file.size, "ftype" : file.type};
			el.uploadify('settings','formData',params);
		},
		onUploadProgress : function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {
			var percentage = Math.round(bytesUploaded / bytesTotal * 100);
			$("#jdt_"+index).width(percentage*2+'px');
			$("#jd_"+index).html(percentage+"%");
		},
		onUploadSuccess : function(file, data, response) {//�ϴ��ɹ�
			data = eval("(" + data + ")");
			$("#cnvideo"+index).val(data.name);
			$("#video"+index).val(data.uuid);
			$("#jdt_"+index).width('0px');
			$("#jd_"+index).html("");
		}
    });
}