<#import "parts/common.ftl" as c>

<@c.page>
    <#if isCurrentUser??>
        <#include "parts/message_edit.ftl"/>
    </#if>
        <#include "parts/message_list.ftl"/>
</@c.page>