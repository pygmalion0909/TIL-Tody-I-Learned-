# CDATA
* xml 특성상 sql 구문 내 < 같은 걸 이용할 수 없다. <![CDATA[ 여기에 문자열을 쓰면 됌 ]]> 이렇게 하면 XML 파서가 PCDATA로 인식하지 않는다.