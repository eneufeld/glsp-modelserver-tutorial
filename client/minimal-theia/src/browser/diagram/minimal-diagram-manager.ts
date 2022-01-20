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
import { GLSPDiagramManager, GLSPWidgetOpenerOptions, GLSPWidgetOptions } from '@eclipse-glsp/theia-integration/lib/browser';
import { codicon } from '@theia/core/lib/browser';
import URI from '@theia/core/lib/common/uri';
import { WorkspaceService } from '@theia/workspace/lib/browser';
import { inject, injectable, postConstruct } from 'inversify';
import { DiagramWidgetOptions } from 'sprotty-theia';

import { MinimalLanguage } from '../../common/minimal-language';

export const DIAGRAM_ICON_CLASS = codicon('dashboard');

export interface MinimalDiagramWidgetOptions extends DiagramWidgetOptions, GLSPWidgetOptions {
    workspaceRoot: string;
}

@injectable()
export class MinimalDiagramManager extends GLSPDiagramManager {

    @inject(WorkspaceService) workspaceService: WorkspaceService;

    readonly diagramType = MinimalLanguage.diagramType;
    readonly label = MinimalLanguage.label + ' Editor';

    private workspaceRoot: string;

    @postConstruct()
    protected async initialize(): Promise<void> {
        super.initialize();
        this.workspaceService.roots.then(roots => this.workspaceRoot = roots[0].resource.toString());
    }

    protected createWidgetOptions(uri: URI, options?: GLSPWidgetOpenerOptions): MinimalDiagramWidgetOptions {
        return {
            ...super.createWidgetOptions(uri, options),
            workspaceRoot: this.workspaceRoot
        } as MinimalDiagramWidgetOptions;
    }

    get fileExtensions(): string[] {
        return MinimalLanguage.fileExtensions;
    }

    get iconClass(): string {
        return DIAGRAM_ICON_CLASS;
    }

}
