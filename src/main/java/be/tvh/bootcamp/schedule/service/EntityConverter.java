package be.tvh.bootcamp.schedule.service;

@FunctionalInterface
public interface EntityConverter<SOURCE, TARGET> {

	public TARGET convert(SOURCE source);
}
