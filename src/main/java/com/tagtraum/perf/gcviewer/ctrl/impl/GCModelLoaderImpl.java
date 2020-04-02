package com.tagtraum.perf.gcviewer.ctrl.impl;

import com.tagtraum.perf.gcviewer.imp.DataReaderException;
import com.tagtraum.perf.gcviewer.imp.DataReaderFacade;
import com.tagtraum.perf.gcviewer.model.GCModel;
import com.tagtraum.perf.gcviewer.model.GCResource;

/**
 * Loads the model in a background thread (progress can be tracked by propertyChangeListeners).
 *
 * @author Hans Bausewein
 * @author <a href="mailto:gcviewer@gmx.ch">Joerg Wuethrich</a>
 *         <p>Date: November 8, 2013</p>
 */
public class GCModelLoaderImpl extends AbstractGCModelLoaderImpl {
    private final DataReaderFacade dataReaderFacade;
    private final GCResource gcResource;

    public GCModelLoaderImpl(final GCResource gcResource) {
        super();

        this.gcResource = gcResource;
        this.dataReaderFacade = new DataReaderFacade();
        this.dataReaderFacade.addPropertyChangeListener(this); // receive progress updates from loading
    }

    @Override
    protected GCModel loadGcModel() throws DataReaderException {
        return dataReaderFacade.loadModel(gcResource);
    }

    @Override
    public GCResource getGcResource() {
        return gcResource;
    }
}
