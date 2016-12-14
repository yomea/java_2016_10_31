<?xml version="1.0"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  version="1.0">

  <!-- Output method -->
  <xsl:output encoding="UTF-8"
              indent="no"/>

  <xsl:template match="/">
    <xsl:value-of select="books/book[id=1]">
    	选出等于一的书
    </xsl:value-of>
  </xsl:template>

</xsl:stylesheet>
