
package com.google.cloud.training.dataanalyst.javahelp;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;

/**
 * A dataflow pipeline that prints the lines that match a specific search term
 * 
 * @author vlakshmanan
 *
 */
public class Grep {

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		PipelineOptions options = PipelineOptionsFactory.fromArgs(args).withValidation().create();
		Pipeline p = Pipeline.create(options);

		String input = "src/main/java/com/google/cloud/training/dataanalyst/javahelp/*.java";
		String outputPrefix = "/tmp/output";
		final String searchTerm = "import";

		p //
				.apply("GetJava", TextIO.read().from(input)) //
				.apply("Grep", ParDo.of(new DoFn<String, String>() {
					@ProcessElement
					public void processElement(ProcessContext c) throws Exception {
						String line = c.element();
						if (line.contains(searchTerm)) {
							c.output(line);
						}
					}
				})) //
				.apply(TextIO.write().to(outputPrefix).withSuffix(".txt").withoutSharding());

		p.run();
	}
}
