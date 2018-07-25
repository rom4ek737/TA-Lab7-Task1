<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<!--<?xml-stylesheet type="test/xsl" href="mySite.xsl"?>-->
    <xsl:template match="/Site">
        <html>
            <head>
                <title>Site</title>
            </head>
            <body>
                <h2>My Sites</h2>
                <table border="1">
                        <tr bgcolor="#9acd32">
                                <th>title</th>
                                <th>siteType</th>
                                <th>email</th>
                                <th>news</th>
                                <th>archive</th>
                <th>vouting</th>
                <th>paid</th>
                <th>authorize</th>
                </tr>
                <xsl:for-each select="sites">
                    <tr>
                        <td><xsl:value-of select="title"/></td>
                        <td><xsl:value-of select="siteType"/></td>
                        <xsl:for-each select="chars">
                            <td><xsl:value-of select="email"/></td>
                            <td><xsl:value-of select="news"/></td>
                            <td><xsl:value-of select="archive"/></td>
                            <td><xsl:value-of select="vouting"/></td>
                            <td><xsl:value-of select="paid"/></td>
                        </xsl:for-each>
                        <td><xsl:value-of select="authorize"/></td>
                    </tr>
                </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>