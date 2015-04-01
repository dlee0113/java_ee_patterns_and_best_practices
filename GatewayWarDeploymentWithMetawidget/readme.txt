GatewayWarDeploymentWithMetawidget
----------------------------------

This example demonstrates the use of Metawidget (http://metawidget.org) within
a Java EE application. It is almost identical to the Java EE Patterns
GatewayWarDeployment example, with slight changes to incorporate Metawidget.

Developers can 'diff' this project against GatewayWarDeployment to understand
the changes typically required to incorporate Metawidget (see LoadView.java) and
the code savings it typically brings (see createorder.xhtml).

However, this example is *not* a good demonstration of all the features of
Metawidget. These can be found in the /examples folder of the Metawidget
distribution.

Note: this NetBeans project expects Metawidget to be installed at its default
location (/metawidget-1.05/metawidget.jar)