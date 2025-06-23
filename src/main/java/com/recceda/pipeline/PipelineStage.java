package com.recceda.pipeline;


public interface PipelineStage<I, O> {

    /**
     * Processes the input data and returns the processed output.
     *
     * @param input the input data to process
     * @return the processed output data
     */
    O process(Object input);

    /**
     * Returns the name of this pipeline stage.
     *
     * @return the name of the stage
     */
    String getName();

}