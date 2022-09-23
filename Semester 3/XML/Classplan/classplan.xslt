<?xml version="1.0" encoding="UTF-8"?>
<!-- CODED BY: Leon Mohan -->
<!-- /////////////////////////////////// -->

<xsl:stylesheet  xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/1999/xhtml" version="1.0">

<xsl:template match="/">

<html>
    <head><link rel="stylesheet" type="text/css" href="classplan.css"/></head>
    
	<body>
		<!-- Main table creation-->
        <table id="classPlan">
            <!-- Table's headers -->
            <tr id="headers">
                <th id="header"><xsl:value-of select="ClassPlan/ModuleHeader"/></th>
                <th id="header"><xsl:value-of select="ClassPlan/TopicHeader"/></th>
                <th id="header"><xsl:value-of select="ClassPlan/ActivityHeader"/></th>
                <th id="header"><xsl:value-of select="ClassPlan/WeightHeader"/></th>
            </tr>
            <!-- Gets all WeekModules stated in the XML document, and puts that information into the table -->
            <xsl:for-each select="ClassPlan/WeekModule">
                <tr>
                    <td><xsl:value-of select="Week"/><br/><xsl:value-of select="ModuleName"/></td>
                    <td><ul><xsl:for-each select="Topic"> <li><xsl:value-of select="TopicInformation"/></li> </xsl:for-each></ul></td>
                    <td><ul><xsl:for-each select="Activity"> <li><xsl:value-of select="ActivityName"/></li> </xsl:for-each></ul></td>
                    <td id="weight"><xsl:for-each select="Activity"> <xsl:value-of select="Weight"/> <br/> </xsl:for-each></td>
                </tr>
            </xsl:for-each>
        </table>

        <!-- Creation of the summary table and adding its contents. -->
        <table>
            <tr>
                <th><xsl:value-of select="ClassPlan/Summary/SummaryHeader"/></th>
            </tr>
            <tr>
                <th><xsl:value-of select="ClassPlan/Summary/Labs/Name"/></th>
                <td><xsl:value-of select="ClassPlan/Summary/Labs/Weight"/></td>
            </tr>
            <tr>
                <th><xsl:value-of select="ClassPlan/Summary/Quizzes/Name"/></th>
                <td><xsl:value-of select="ClassPlan/Summary/Quizzes/Weight"/></td>
            </tr>
            <tr>
                <th><xsl:value-of select="ClassPlan/Summary/Assignments/Name"/></th>
                <td><xsl:value-of select="ClassPlan/Summary/Assignments/Weight"/></td>
            </tr>
            <tr>
                <th><xsl:value-of select="ClassPlan/Summary/Projects/Name"/></th>
                <td><xsl:value-of select="ClassPlan/Summary/Projects/Weight"/></td>
            </tr>
            <tr>
                <th><xsl:value-of select="ClassPlan/Summary/Total/Name"/></th>
                <td><b><xsl:value-of select="ClassPlan/Summary/Total/Weight"/></b></td>
            </tr>
        </table>
    </body>
</html>

</xsl:template>
</xsl:stylesheet>