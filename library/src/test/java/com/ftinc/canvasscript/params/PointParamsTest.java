/*
 * Copyright (c) 2017 52inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ftinc.canvasscript.params;


import android.graphics.Canvas;
import android.graphics.Paint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class PointParamsTest {

    private static final float X = 209f;
    private static final float Y = 10f;

    @Mock Paint paint;
    @Mock Canvas canvas;


    @Test
    public void shouldDrawSinglePoint() {
        PointParams params = new PointParams(X, Y, paint);

        int result = params.draw(canvas);

        verify(canvas).drawPoint(X, Y, paint);
        assertThat(result, is(CanvasParams.NO_SAVE));
    }


    @Test
    public void shouldDrawMultiplePoints() {
        float[] pts = new float[] {
                X, Y,
                0f, 10f,
                20f, 40f
        };
        PointParams params = new PointParams(pts, paint);

        int result = params.draw(canvas);

        verify(canvas).drawPoints(pts, 0, pts.length, paint);
        assertThat(result, is(CanvasParams.NO_SAVE));
    }
}