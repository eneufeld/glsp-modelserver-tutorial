/**
 */
package com.eclipsesource.example.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.eclipsesource.example.model.Task#getName <em>Name</em>}</li>
 *   <li>{@link com.eclipsesource.example.model.Task#getSubtasks <em>Subtasks</em>}</li>
 * </ul>
 *
 * @see com.eclipsesource.example.model.ModelPackage#getTask()
 * @model
 * @generated
 */
public interface Task extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.eclipsesource.example.model.ModelPackage#getTask_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.eclipsesource.example.model.Task#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Subtasks</b></em>' containment reference list.
	 * The list contents are of type {@link com.eclipsesource.example.model.Task}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subtasks</em>' containment reference list.
	 * @see com.eclipsesource.example.model.ModelPackage#getTask_Subtasks()
	 * @model containment="true"
	 * @generated
	 */
	EList<Task> getSubtasks();

} // Task
