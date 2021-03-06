/*
 * Copyright 2006-2008 Web Cohesion
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codehaus.enunciate.modules.xml.config;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.RuleSetBase;

/**
 * The set of rules to add for the XML module configuration.
 *
 * @author Ryan Heaton
 */
public class XMLRuleSet extends RuleSetBase {

  public void addRuleInstances(Digester digester) {
    digester.addObjectCreate("enunciate/modules/xml/schema", SchemaConfig.class);
    digester.addSetProperties("enunciate/modules/xml/schema");
    digester.addSetNext("enunciate/modules/xml/schema", "addSchemaConfig");

    digester.addBeanPropertySetter("enunciate/modules/xml/schema/appinfo", "appinfo");

    digester.addObjectCreate("enunciate/modules/xml/wsdl", WsdlConfig.class);
    digester.addSetProperties("enunciate/modules/xml/wsdl");
    digester.addSetNext("enunciate/modules/xml/wsdl", "addWsdlConfig");

    digester.addCallMethod("enunciate/modules/xml/facets/include", "addFacetInclude", 1);
    digester.addCallParam("enunciate/modules/xml/facets/include", 0, "name");
    digester.addCallMethod("enunciate/modules/xml/facets/exclude", "addFacetExclude", 1);
    digester.addCallParam("enunciate/modules/xml/facets/exclude", 0, "name");

    //todo: option to not inline request/response wrappers into the wsdl.
  }

}