package com.bip.common.service;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.*;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;



public class XmlParse {
	public static AdapterResponse xmlGetValue(String body) {

		ArrayList rsp = new ArrayList();
		AdapterResponse adapterResponse = new AdapterResponse();
		StringReader read = new StringReader(body);
		InputSource source = new InputSource(read);
		SAXBuilder sb = new SAXBuilder();
		try {
			Document doc = sb.build(source);
			Element root = doc.getRootElement();
			List jd = root.getChildren();
			Namespace ns = root.getNamespace();
			Element et = null;
			for (int i = 0; i < jd.size(); i++) {
				et = (Element) jd.get(i);
				rsp.add(i, et.getText().toString());
			//	System.out.println(et.getText());
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (rsp.size() < 1) {
			adapterResponse.setCode(399);
			adapterResponse.setDescrption("get web service error!");
			return adapterResponse;
		}

		int i = 0;
		for (Object s : rsp){
			if (i == 0) {
				adapterResponse.setCode(Integer.parseInt(s.toString()));
			} else if (i == 1) {
				adapterResponse.setDescrption(s.toString());
			} else {
				adapterResponse.setEncodedBody(s.toString());
				
			}
			i++;
		}

		return adapterResponse;
	}

	/**
	 * 把Xml最底层的数据转换成map
	 * @param body
	 * @return
	 */
	public static Map xmlToMap(String body) {
		Map resMap=new HashMap();
		StringReader read = new StringReader(body);
		InputSource source = new InputSource(read);
		SAXBuilder sb = new SAXBuilder();
		try {
			Document doc = sb.build(source);
			Element root = doc.getRootElement();
			List jd = root.getChildren();
			Namespace ns = root.getNamespace();
			Element et = null;
			for (int i = 0; i < jd.size(); i++) {
				et = (Element) jd.get(i);
				
			//	System.out.println(et.getName()+"=="+et.getText());
//				rsp.add(i, et.getText().toString());
				resMap.put(et.getName(), et.getText());
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resMap;
	}

	
	
	
	public static void main(String[] args) {
//		XmlParse sss = new XmlParse();
//		String body = "<?xml version=\"1.0\" encoding=\"GB2312\"?><result><code>100</code><description>this is a description!</description><encodebody><![CDATA[<loginUserInfo><sessionId>5DDD3F8A62068B2A484987477B343C4D</sessionId></loginUserInfo>]]></encodebody></result>";
//		sss.xmlGetValue(body);
//		// System.out.println(ttt);
		String ss="<xml-fragment><dwbh>001</dwbh><bh>001</bh><dwlb>0003</dwlb></xml-fragment>";
		String ss1="<companyInfosbb><sbbType><sblx>3</sblx><nd>2010</nd><yf>6</yf><sbrq>2010-9-10</sbrq><tbrq>2010-6-6</tbrq><tbr>李四</tbr><tbfzr>张三</tbfzr><dwbh>001</dwbh><status>1</status></sbbType><companyInfotype><companyBasicFBs><companyBasicFBType><gyzcz>10000</gyzcz><xssr>111111</xssr><zhnyxfldl>2222</zhnyxfldl><zhnyxfldj>33333</zhnyxfldj><flag>1</flag></companyBasicFBType><companyBasicFBType><gyzcz>10000</gyzcz><xssr>111111</xssr><zhnyxfldl>2222</zhnyxfldl><zhnyxfldj>33333</zhnyxfldj><flag>2</flag></companyBasicFBType><companyBasicFBType><gyzcz>10000</gyzcz><xssr>111111</xssr><zhnyxfldl>2222</zhnyxfldl><zhnyxfldj>33333</zhnyxfldj><flag>3</flag></companyBasicFBType></companyBasicFBs><companyFgss><companyFgsType><fgsmc>某某科技有限公司</fgsmc><fddbr>王某某</fddbr><lxdh>0536-656565</lxdh></companyFgsType><companyFgsType><fgsmc>某某科技有限公司</fgsmc><fddbr>王某某</fddbr><lxdh>0536-656565</lxdh></companyFgsType></companyFgss><companyGlzds><companyGlzdType><nyjszd>撒离开的积分来说肯定积分老师=0</nyjszd></companyGlzdType><companyGlzdType><nyjszd>撒离开的积分来说肯定积分老师=1</nyjszd></companyGlzdType><companyGlzdType><nyjszd>撒离开的积分来说肯定积分老师=2</nyjszd></companyGlzdType></companyGlzds><companyGyzbs><companyGyzb><zbmc>拉速度快就</zbmc><scnl>234234</scnl><jldw>吨</jldw><sl>5</sl></companyGyzb><companyGyzb><zbmc>拉速度快就</zbmc><scnl>234234</scnl><jldw>吨</jldw><sl>5</sl></companyGyzb><companyGyzb><zbmc>拉速度快就</zbmc><scnl>234234</scnl><jldw>吨</jldw><sl>5</sl></companyGyzb></companyGyzbs><companyProducts><companyProductType><cpbh>321321</cpbh><ncl>20000</ncl><dwcpnh>2222</dwcpnh><zhnhdlz>234234</zhnhdlz><zhnhdjz>54654</zhnhdjz></companyProductType><companyProductType><cpbh>321321</cpbh><ncl>20000</ncl><dwcpnh>2222</dwcpnh><zhnhdlz>234234</zhnhdlz><zhnhdjz>54654</zhnhdjz></companyProductType><companyProductType><cpbh>321321</cpbh><ncl>20000</ncl><dwcpnh>2222</dwcpnh><zhnhdlz>234234</zhnhdlz><zhnhdjz>54654</zhnhdjz></companyProductType></companyProducts><companyJnGlys><companyJnGlyType><glyxm>王某0</glyxm><pxh>鲁B987987</pxh><lxdh>0536-888888</lxdh></companyJnGlyType><companyJnGlyType><glyxm>王某1</glyxm><pxh>鲁B987987</pxh><lxdh>0536-888888</lxdh></companyJnGlyType><companyJnGlyType><glyxm>王某2</glyxm><pxh>鲁B987987</pxh><lxdh>0536-888888</lxdh></companyJnGlyType><companyJnGlyType><glyxm>王某3</glyxm><pxh>鲁B987987</pxh><lxdh>0536-888888</lxdh></companyJnGlyType><companyJnGlyType><glyxm>王某4</glyxm><pxh>鲁B987987</pxh><lxdh>0536-888888</lxdh></companyJnGlyType></companyJnGlys><companyBasicType><dwbh>001</dwbh><bh>001</bh><dwlb>0003</dwlb></companyBasicType></companyInfotype></companyInfosbb>";
		XmlParse.xmlToMap(ss);
	}
}
