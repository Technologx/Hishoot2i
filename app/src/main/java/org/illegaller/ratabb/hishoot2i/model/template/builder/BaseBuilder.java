package org.illegaller.ratabb.hishoot2i.model.template.builder;

import android.content.Context;
import android.graphics.Point;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import org.illegaller.ratabb.hishoot2i.model.template.Template;
import org.illegaller.ratabb.hishoot2i.model.template.TemplateType;

public abstract class BaseBuilder {
  public Point templatePoint;
  public String name;
  public String author;
  public String id;
  public TemplateType type;
  public String previewFile;
  public String frameFile;
  public String glareFile;
  public String shadowFile;
  public Point overlayOffset;
  public Point leftTop;
  public Point rightTop;
  public Point leftBottom;
  public Point rightBottom;
  boolean isSuccessBuild;
  private Reference<Context> mContextRef;

  BaseBuilder(Context context) {
    this.mContextRef = new WeakReference<>(context);
  }

  Context getContext() {
    return this.mContextRef.get();
  }

  public abstract Template build() throws Exception;
}
