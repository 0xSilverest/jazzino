package com.silverest.utils;

import java.util.function.Function;

public final class Lens<A, B> {

  private final Function<A, B> get;
  private final Function<B, Function<A, A>> set;

  private Lens(Function<A, B> get, Function<B, Function<A, A>> set) {
    this.get = get;
    this.set = set;
  }

  public static <A, B> Lens<A, B> of(Function<A, B> get, Function<B, Function<A, A>> set) {
    return new Lens<>(get, set);
  }

  public B get(A a) {
    return get.apply(a);
  }

  public A set(B b, A a) {
    return set.apply(b).apply(a);
  }

  public A mod(final Function<B, B> f, A a) {
    return set(f.apply(get(a)), a);
  }

  public <C> Lens<C, B> compose(final Lens<C, A> that) {
    return Lens.of(c -> get(that.get(c)), b -> c -> that.set(set(b, that.get(c)), c));
  }

  public <C> Lens<A, C> andThen(final Lens<B, C> that) {
    return that.compose(this);
  }
}
