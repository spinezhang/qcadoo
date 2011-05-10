/**
 * ***************************************************************************
 * Copyright (c) 2010 Qcadoo Limited
 * Project: Qcadoo Framework
 * Version: 0.4.0
 *
 * This file is part of Qcadoo.
 *
 * Qcadoo is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation; either version 3 of the License,
 * or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 * ***************************************************************************
 */

package com.qcadoo.model.api.search;

import com.qcadoo.model.api.Entity;

/**
 * Object represents the criteria builder for finding entities.
 * 
 * @since 0.4.0
 */
public interface SearchCriteriaBuilder {

    /**
     * Finds entities using this criteria.
     * 
     * @return search result
     */
    SearchResult list();

    /**
     * Finds unique entity.
     * 
     * @return entity
     */
    Entity uniqueResult();

    /**
     * Sets the ascending order by given field, by default there is an order by id.
     * 
     * @return this search builder
     */
    SearchCriteriaBuilder orderAscBy(String fieldName);

    /**
     * Sets the descending order by given field, by default there is an order by id.
     * 
     * @return this search builder
     */
    SearchCriteriaBuilder orderDescBy(String fieldName);

    /**
     * Sets the max results, by default there is no limit.
     * 
     * @param maxResults
     *            max results
     * @return this search builder
     */
    SearchCriteriaBuilder setMaxResults(int maxResults);

    /**
     * Sets the first result, by default the first result is equal to zero.
     * 
     * @param firstResult
     *            first result
     * @return this search builder
     */
    SearchCriteriaBuilder setFirstResult(int firstResult);

    /**
     * Adds the "equals to" restriction. If field has string type and value contains "%", "*", "_" or "?" the "like" restriction
     * will be used.
     * 
     * @param fieldName
     *            field's name
     * @param value
     *            expected value
     * @see #like(String, String)
     * @return this search builder
     */
    SearchCriteriaBuilder isEq(String fieldName, Object value);

    /**
     * Adds the "like" restriction.
     * 
     * @param fieldName
     *            field's name
     * @param value
     *            expected value
     * @return this search builder
     */
    SearchCriteriaBuilder like(String fieldName, String value);

    /**
     * Adds the "less than or equals to" restriction.
     * 
     * @param fieldName
     *            field's name
     * @param value
     *            expected value
     * @return this search builder
     */
    SearchCriteriaBuilder isLe(String fieldName, Object value);

    /**
     * Adds the "less than" restriction.
     * 
     * @param fieldName
     *            field's name
     * @param value
     *            expected value
     * @return this search builder
     */
    SearchCriteriaBuilder isLt(String fieldName, Object value);

    /**
     * Adds the "greater than or equals to" restriction.
     * 
     * @param fieldName
     *            field's name
     * @param value
     *            expected value
     * @return this search builder
     */
    SearchCriteriaBuilder isGe(String fieldName, Object value);

    /**
     * Adds the "greater than" restriction.
     * 
     * @param fieldName
     *            field's name
     * @param value
     *            expected value
     * @return this search builder
     */
    SearchCriteriaBuilder isGt(String fieldName, Object value);

    /**
     * Adds the "not equals to" restriction. If field has string type and value contains "%", "*", "_" or "?" the "not like"
     * restriction will be used.
     * 
     * @param fieldName
     *            field's name
     * @param value
     *            expected value
     * @see #like(String, String)
     * @return this search builder
     */
    SearchCriteriaBuilder isNe(String fieldName, Object value);

    /**
     * Adds the "not null" restriction.
     * 
     * @param fieldName
     *            field's name
     * @return this search builder
     */
    SearchCriteriaBuilder isNotNull(String fieldName);

    /**
     * Adds the "null" restriction.
     * 
     * @param fieldName
     *            field's name
     * @return this search builder
     */
    SearchCriteriaBuilder isNull(String fieldName);

    /**
     * Open "not" section. The next restriction will be negated.
     * 
     * @see #closeNot()
     * @return this search builder
     */
    SearchCriteriaBuilder openNot();

    /**
     * Close "not" section.
     * 
     * @see #openNot()
     * @return this search builder
     */
    SearchCriteriaBuilder closeNot();

    /**
     * Open "or" section. Only one restriction in this section must be met.
     * 
     * @see #closeOr()
     * @return this search builder
     */
    SearchCriteriaBuilder openOr();

    /**
     * Close "or" section.
     * 
     * @see #openOr()
     * @return this search builder
     */
    SearchCriteriaBuilder closeOr();

    /**
     * Open "and" section. All restrictions in this section must be met. This is section is opened by default.
     * 
     * @see #closeAnd()
     * @return this search builder
     */
    SearchCriteriaBuilder openAnd();

    /**
     * Close "and" section.
     * 
     * @see #openAnd()
     * @return this search builder
     */
    SearchCriteriaBuilder closeAnd();

    /**
     * Adds the "belongs to" restriction.
     * 
     * @param fieldName
     *            field's name
     * @param entityOrId
     *            entity or its id
     * @return this search builder
     */
    SearchCriteriaBuilder belongsTo(String fieldName, Object entityOrId);

    /**
     * Adds the "equals to" restriction for id field.
     * 
     * @param id
     *            expected id
     * 
     * @return this search builder
     */
    SearchCriteriaBuilder isIdEq(Long id);

    /**
     * Adds the "less than or equals to" restriction for id field.
     * 
     * @param id
     *            expected id
     * 
     * @return this search builder
     */
    SearchCriteriaBuilder isIdLe(Long id);

    /**
     * Adds the "less than" restriction for id field.
     * 
     * @param id
     *            expected id
     * 
     * @return this search builder
     */
    SearchCriteriaBuilder isIdLt(Long id);

    /**
     * Adds the "greater than or equals to" restriction for id field.
     * 
     * @param id
     *            expected id
     * 
     * @return this search builder
     */
    SearchCriteriaBuilder isIdGe(Long id);

    /**
     * Adds the "greater than" restriction for id field.
     * 
     * @param id
     *            expected id
     * 
     * @return this search builder
     */
    SearchCriteriaBuilder isIdGt(Long id);

    /**
     * Adds the "not equals to" restriction for id field.
     * 
     * @param id
     *            expected id
     * 
     * @return this search builder
     */
    SearchCriteriaBuilder isIdNe(Long id);

}
