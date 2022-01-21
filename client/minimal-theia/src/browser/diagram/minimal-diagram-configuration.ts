/********************************************************************************
 * Copyright (c) 2020 EclipseSource and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/
import 'sprotty-theia/css/theia-sprotty.css';

import { creatMinimalDiagramContainer } from 'examaple-glsp';
import { configureDiagramServer, GLSPDiagramConfiguration, TheiaDiagramServer } from '@eclipse-glsp/theia-integration';
import { Container, injectable } from '@theia/core/shared/inversify';

import { MinimalLanguage } from '../../common/minimal-language';
import { MinimalDiagramServer } from './minimal-diagram-server';

@injectable()
export class MinimalDiagramConfiguration extends GLSPDiagramConfiguration {

    diagramType: string = MinimalLanguage.diagramType;

    doCreateContainer(widgetId: string): Container {
        const container = creatMinimalDiagramContainer(widgetId);
        configureDiagramServer(container, MinimalDiagramServer);
        container.bind(TheiaDiagramServer).toService(MinimalDiagramServer);
        return container;
    }
}
